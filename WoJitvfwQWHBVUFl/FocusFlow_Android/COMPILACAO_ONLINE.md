# Guia Completo: Compilar FocusFlow Online com Codemagic

Este guia mostra como compilar o FocusFlow sem precisar instalar Android Studio no seu computador.

## O que é Codemagic?

**Codemagic** é um serviço online gratuito que compila aplicativos Android automaticamente. Você envia o código, e ele gera o APK pronto para instalar no seu celular.

## Passo 1: Preparar o Código no GitHub

### 1.1 Criar uma Conta no GitHub (se não tiver)

1. Abra seu navegador e vá para: https://github.com/
2. Clique em **"Sign up"**
3. Preencha seus dados (email, senha, nome de usuário)
4. Confirme seu email
5. Pronto! Você tem uma conta no GitHub

### 1.2 Criar um Repositório

1. Faça login no GitHub
2. Clique no ícone **"+"** no canto superior direito
3. Selecione **"New repository"**
4. Preencha:
   - **Repository name:** `FocusFlow_Android`
   - **Description:** `Gerenciador de Foco e Tempo de Tela`
   - **Public:** Deixe marcado (mais fácil para Codemagic)
5. Clique em **"Create repository"**

### 1.3 Fazer Upload do Código

Você tem duas opções:

**Opção A: Usando Git (Recomendado)**

1. Abra o Prompt de Comando (Windows) ou Terminal (Mac/Linux)
2. Navegue até a pasta do FocusFlow:
   ```
   cd /caminho/para/FocusFlow_Android
   ```
3. Execute estes comandos:
   ```
   git init
   git add .
   git commit -m "Primeira versão do FocusFlow"
   git branch -M main
   git remote add origin https://github.com/seu_usuario/FocusFlow_Android.git
   git push -u origin main
   ```
4. Quando pedir usuário/senha, use suas credenciais do GitHub

**Opção B: Usando a Interface Web (Mais Simples)**

1. No GitHub, clique em **"uploading an existing file"**
2. Selecione todos os arquivos da pasta `FocusFlow_Android`
3. Clique em **"Commit changes"**

## Passo 2: Configurar Codemagic

### 2.1 Acessar Codemagic

1. Abra seu navegador e vá para: https://codemagic.io/
2. Clique em **"Sign Up"** (canto superior direito)
3. Clique em **"Sign up with GitHub"**
4. Autorize Codemagic a acessar seus repositórios GitHub
5. Pronto! Você está logado no Codemagic

### 2.2 Conectar o Repositório

1. No Codemagic, clique em **"Create New App"** ou **"Add Application"**
2. Selecione **"GitHub"**
3. Procure por **"FocusFlow_Android"** na lista
4. Clique em **"Select"**
5. Clique em **"Next"**

### 2.3 Configurar a Compilação

1. Codemagic detectará automaticamente que é um projeto Android
2. Você verá uma tela com as configurações
3. Deixe as configurações padrão (estão corretas para FocusFlow)
4. Clique em **"Start Building"**

## Passo 3: Aguardar a Compilação

1. Você verá uma barra de progresso
2. A compilação geralmente leva **5-15 minutos**
3. Você pode acompanhar o progresso em tempo real
4. Quando terminar, você verá uma mensagem de sucesso

## Passo 4: Baixar o APK

1. Após a compilação ser concluída, clique em **"Download APK"**
2. O arquivo `app-release.apk` será baixado
3. Salve em um local fácil de encontrar (ex: Desktop)

## Passo 5: Transferir para o Celular

### Opção A: Via USB (Mais Rápido)

1. Conecte seu celular ao computador com um cabo USB
2. Copie o arquivo `app-release.apk` para a pasta **Downloads** do celular
3. Desconecte o celular

### Opção B: Via Email

1. Envie o arquivo `app-release.apk` para seu email
2. Abra o email no celular
3. Baixe o arquivo

### Opção C: Via Google Drive

1. Faça upload do arquivo para Google Drive
2. Abra Google Drive no celular
3. Baixe o arquivo

## Passo 6: Instalar no Celular

### 6.1 Ativar Instalação de Fontes Desconhecidas

1. Abra **Configurações** no seu celular
2. Vá para **Segurança** (ou **Privacidade**)
3. Procure por **"Fontes desconhecidas"** ou **"Instalar apps desconhecidos"**
4. Ative a opção (você pode ver um aviso - clique em **"Permitir"**)

### 6.2 Instalar o APK

1. Abra o **Gerenciador de Arquivos** (ou **Arquivos**)
2. Navegue até a pasta **Downloads**
3. Procure por `app-release.apk`
4. Toque no arquivo
5. Clique em **"Instalar"**
6. Aguarde a instalação terminar
7. Clique em **"Abrir"** ou **"Concluído"**

## Passo 7: Configurar Permissões

1. Abra o **FocusFlow** no seu celular
2. Você verá um tutorial de permissões
3. Siga as instruções para ativar:
   - **Permissão de Acessibilidade**
   - **Permissão de Sobreposição de Tela**
   - **Permissão de Acesso de Uso**
4. Pronto! O FocusFlow está pronto para usar

## Troubleshooting

### "Erro na compilação"
- Verifique se todos os arquivos estão no repositório GitHub
- Tente fazer a compilação novamente no Codemagic

### "Arquivo APK não baixa"
- Aguarde alguns segundos após a compilação terminar
- Tente atualizar a página do Codemagic

### "Não consigo instalar o APK"
- Certifique-se de que ativou "Fontes desconhecidas"
- Tente desinstalar qualquer versão anterior do FocusFlow
- Verifique se tem espaço em disco no celular

### "O app não abre"
- Reinicie o celular
- Desinstale e reinstale o FocusFlow
- Verifique se tem Android 9 ou superior

## Próximas Compilações

Depois da primeira compilação, você pode fazer alterações no código e recompilar:

1. Faça as alterações no código
2. Faça upload para GitHub (usando `git push` ou a interface web)
3. No Codemagic, clique em **"Start Building"** novamente
4. Aguarde a compilação
5. Baixe o novo APK

## Dúvidas?

Se tiver problemas, você pode:
- Consultar a documentação do Codemagic: https://docs.codemagic.io/
- Procurar ajuda no GitHub: https://github.com/help
- Entrar em contato com o suporte do Codemagic

---

**Parabéns!** Você compilou e instalou o FocusFlow com sucesso! 🎉
