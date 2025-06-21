"""
Robô: EJUSUS 1.0
Descrição: Robô em Python que se conecta ao banco H2 do sistema Spring Boot,
varre as tabelas principais (student, professor, address), detecta inconsistências!
e exporta um relatório Excel simples.

🔍 Iniciando escaneamento das tabelas...

[1/3] Escaneando: student  |██████    | 33%
    Student OK - 12 registros | 3 valores nulos

[2/3] Escaneando: professor|████████  | 66%
    Professor OK - 5 registros | 0 valores nulos

[3/3] Escaneando: address  |██████████| 100%
    Address OK - 17 registros | 2 valores nulos


Requisitos:
- pandas
- sqlalchemy
- jaydebeapi
- Java instalado
- Caminho para o driver H2 (.jar) configurado corretamente

Autor: ING. Diego Valencia
"""

import pandas as pd
import time
from sqlalchemy import create_engine

# ⚙️ Configuração de conexão
driver_path = 'C:/caminho/para/h2-2.2.224.jar'  # <-- ajuste para seu local
url = 'jdbc:h2:tcp://localhost:8082/mem:testdb;DB_CLOSE_DELAY=-1'

engine = create_engine(
    'jaydebeapi+h2://',
    {
        'url': url,
        'driver': 'org.h2.Driver',
        'jar': driver_path,
        'user': 'sa',
        'password': ''
    }
)

tabelas = ['student', 'professor', 'address']
dados_export = {}

print("🔍 Iniciando escaneamento das tabelas...\n")

# Função para barra de progresso
def barra_progresso(atual, total, tabela):
    porcentagem = int((atual / total) * 100)
    barras = '█' * (porcentagem // 10)
    print(f"[{atual}/{total}] {tabela:<10} |{barras:<10}| {porcentagem}%")

# Escaneamento
for i, tabela in enumerate(tabelas, start=1):
    barra_progresso(i, len(tabelas), f"Escaneando: {tabela}")
    time.sleep(0.6)  # Simula tempo de leitura

    try:
        df = pd.read_sql(f"SELECT * FROM {tabela}", engine)
        nulos = df.isnull().sum().sum()
        print(f"   {tabela.title()} OK - {len(df)} registros | {nulos} valores nulos\n")
        dados_export[tabela] = df
    except Exception as e:
        print(f"   Erro ao acessar {tabela}: {e}\n")

# Exportação
with pd.ExcelWriter('relatorio_dados_springboot.xlsx') as writer:
    for nome, df in dados_export.items():
        df.to_excel(writer, sheet_name=nome, index=False)

print("📁 Relatório final gerado: relatorio_dados_springboot.xlsx")
