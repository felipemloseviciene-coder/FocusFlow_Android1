# FocusFlow - TODO

## Funcionalidades Principais

- [x] Estrutura base do aplicativo Android com Kotlin
- [x] Interface de permissões guiada com tutorial visual (parcial - estrutura base pronta)
- [x] Tela inicial com navegação principal
- [x] Tela de configuração de aplicativos a bloquear (estrutura pronta)
- [x] Tela de agendamento de períodos de foco (suporte a múltiplos períodos por dia) (modelo de dados pronto)
- [x] Serviço de Acessibilidade para detectar e bloquear apps
- [x] Sobreposição de tela para avisos de pausa e bloqueio
- [x] Lógica de agendamento recorrente (dias da semana)
- [x] Persistência de dados (banco de dados local - Room Database)
- [x] Serviço em primeiro plano para operação contínua
- [x] Gerenciamento de notificações (silenciar durante foco)
- [x] Interface de bloqueio com opção de "Pular" ou "Adiar"
- [ ] Testes unitários e de integração
- [x] Compilação e empacotamento em APK (pronto para compilação online)

## Tarefas Técnicas

- [x] Configurar projeto Android com Gradle
- [x] Configurar banco de dados local (Room Database)
- [x] Implementar sistema de permissões com verificação de concessão
- [x] Criar componentes de UI (Jetpack Compose)
- [x] Implementar AccessibilityService
- [x] Implementar WindowManager para sobreposição
- [x] Configurar AlarmManager para agendamento (via WorkManager)
- [x] Implementar NotificationListenerService
- [ ] Testes de funcionalidade
- [x] Geração do APK assinado (via Codemagic)

## Melhorias Futuras

- [ ] Adicionar mais opções de customização de temas
- [ ] Implementar estatísticas de uso
- [ ] Adicionar modo de foco com som/vibração
- [ ] Sincronizar dados na nuvem
- [ ] Adicionar suporte a múltiplos perfis de foco
- [ ] Implementar IA para sugerir períodos de foco

## Notas

- O aplicativo requer Android 9 (API 28) ou superior
- Permissões críticas: PACKAGE_USAGE_STATS, SYSTEM_ALERT_WINDOW, BIND_ACCESSIBILITY_SERVICE
- Usuário deve conceder permissões manualmente nas Configurações do Android
- Tema escuro AMOLED foi implementado para economizar bateria
- Código pronto para compilação online via Codemagic
