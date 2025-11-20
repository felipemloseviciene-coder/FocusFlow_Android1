# FocusFlow - Gerenciador de Foco e Tempo de Tela

Um aplicativo Android nativo que ajuda você a gerenciar seu tempo de tela, bloquear aplicativos distraentes durante períodos de foco e manter a produtividade.

## Funcionalidades

- **Múltiplos Períodos de Foco por Dia:** Configure quantos períodos de foco quiser para cada dia da semana
- **Bloqueio de Aplicativos:** Bloqueie aplicativos selecionados durante seus períodos de foco
- **Sobreposição de Tela:** Exiba avisos visuais quando você tenta abrir um app bloqueado
- **Gerenciamento de Notificações:** Silencie notificações de apps bloqueados durante o foco
- **Tutorial de Permissões:** Interface guiada para configurar todas as permissões necessárias
- **Tema Escuro AMOLED:** Design escuro que economiza bateria em telas AMOLED
- **Serviço em Segundo Plano:** Monitora continuamente seus períodos de foco

## Requisitos

- Android 9 (API 28) ou superior
- Mínimo 100 MB de espaço em disco
- Permissões especiais do Android (concedidas manualmente)

## Permissões Necessárias

O FocusFlow requer as seguintes permissões para funcionar:

1. **Permissão de Acessibilidade:** Para detectar quando você tenta abrir um app bloqueado
2. **Permissão de Sobreposição de Tela:** Para exibir a tela de bloqueio
3. **Permissão de Acesso de Uso:** Para monitorar o uso de aplicativos

Todas essas permissões são concedidas manualmente pelo usuário nas Configurações do Android.

## Como Compilar (Usando Codemagic - Recomendado)

### Passo 1: Preparar o Código

1. Certifique-se de que todos os arquivos estão na pasta `/FocusFlow_Android`
2. O projeto está pronto para compilação

### Passo 2: Acessar Codemagic

1. Abra seu navegador e vá para: https://codemagic.io/
2. Clique em **"Sign Up"** ou **"Log In"** (você pode usar sua conta GitHub, Google ou criar uma nova)
3. Após fazer login, clique em **"Create New App"**

### Passo 3: Conectar o Repositório

1. Clique em **"GitHub"** (ou outro provedor de repositório)
2. Autorize o Codemagic a acessar seus repositórios
3. Selecione o repositório do FocusFlow

### Passo 4: Configurar a Compilação

1. Codemagic detectará automaticamente que é um projeto Android
2. Clique em **"Start Building"**
3. Aguarde a compilação terminar (geralmente leva 5-10 minutos)

### Passo 5: Baixar o APK

1. Após a compilação ser concluída, você verá um botão **"Download APK"**
2. Clique para baixar o arquivo `app-release.apk`
3. Transfira o arquivo para seu celular via USB ou email

## Como Instalar no Celular

1. **Ativar Instalação de Fontes Desconhecidas:**
   - Vá para **Configurações > Segurança**
   - Ative **"Fontes Desconhecidas"** ou **"Instalar apps desconhecidos"**

2. **Instalar o APK:**
   - Localize o arquivo `app-release.apk` no seu celular
   - Toque no arquivo para iniciar a instalação
   - Clique em **"Instalar"**

3. **Conceder Permissões:**
   - Abra o FocusFlow
   - Siga o tutorial de permissões
   - Conceda as três permissões necessárias nas Configurações

## Como Usar

1. **Abra o FocusFlow**
2. **Clique em "Adicionar Sessão de Foco"**
3. **Configure:**
   - Nome da sessão
   - Dias da semana
   - Períodos de tempo (você pode adicionar vários por dia)
   - Apps a bloquear
4. **Salve a sessão**
5. **Durante o período de foco, qualquer tentativa de abrir um app bloqueado exibirá a tela de bloqueio**

## Estrutura do Projeto

```
FocusFlow_Android/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/focusflow/app/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── data/
│   │   │   │   │   ├── FocusSession.kt
│   │   │   │   │   ├── FocusSessionDao.kt
│   │   │   │   │   ├── FocusFlowDatabase.kt
│   │   │   │   │   └── FocusSessionRepository.kt
│   │   │   │   ├── services/
│   │   │   │   │   ├── FocusAccessibilityService.kt
│   │   │   │   │   ├── FocusNotificationListenerService.kt
│   │   │   │   │   └── FocusMonitorService.kt
│   │   │   │   ├── receivers/
│   │   │   │   │   └── BootReceiver.kt
│   │   │   │   └── ui/
│   │   │   │       ├── FocusFlowApp.kt
│   │   │   │       ├── BlockScreenActivity.kt
│   │   │   │       ├── screens/
│   │   │   │       │   ├── HomeScreen.kt
│   │   │   │       │   └── SettingsScreen.kt
│   │   │   │       └── theme/
│   │   │   │           ├── Theme.kt
│   │   │   │           └── Type.kt
│   │   │   ├── res/
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── themes.xml
│   │   │   │   └── xml/
│   │   │   │       ├── accessibility_service_config.xml
│   │   │   │       ├── backup_rules.xml
│   │   │   │       └── data_extraction_rules.xml
│   │   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Tecnologias Utilizadas

- **Kotlin:** Linguagem de programação principal
- **Jetpack Compose:** Framework de UI moderno
- **Room Database:** Persistência de dados local
- **Accessibility Service:** Detecção de apps
- **Window Manager:** Sobreposição de tela
- **Work Manager:** Agendamento de tarefas
- **Material Design 3:** Design system

## Troubleshooting

### O bloqueio não está funcionando
- Certifique-se de que o Serviço de Acessibilidade está ativado
- Verifique se a permissão de Sobreposição de Tela foi concedida
- Reinicie o aplicativo

### As notificações não estão sendo silenciadas
- Ative o Serviço de Notificações nas Configurações
- Verifique se o app está na lista de bloqueados

### O aplicativo não inicia
- Verifique se você tem Android 9 ou superior
- Tente desinstalar e reinstalar o aplicativo

## Licença

Este projeto é fornecido como está, sem garantias. Use por sua conta e risco.

## Suporte

Para reportar bugs ou sugerir melhorias, entre em contato com o desenvolvedor.

---

**FocusFlow v1.0.0** - Desenvolvido para ajudar você a manter o foco e a produtividade.
