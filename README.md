# Principi SOLID e come applicarli

Il repo fornisce un esempio di violazioni e refactor per risolvere dei principi solid, in special modo SRP ed OCP.

### Navigazione codebase esplorata al seminario

- Inizialmente si vuole sviluppare una macchinetta del caffè in cui si possono aggiungere gli ingredienti (acqua e chicchi di caffè) e fare il caffè. (branch [main](https://github.com/xtreamsrl/java-solid-unicatt/tree/main)).
- Successivamente si vuole rendere la macchinetta a pagamento senza resto, aggiungendo la possibilità di inserire monetine. (branch [feat/paid-coffee](https://github.com/xtreamsrl/java-solid-unicatt/tree/feat/paid-coffee))
- A questo punto si vuole avere una macchinetta gratuita che faccia anche il cappuccino e sembra una buona idea estendere la classe CoffeeMachine, notando le prime violazioni (SRP/OCP). (branch [feat/cappuccino](https://github.com/xtreamsrl/java-solid-unicatt/tree/feat/cappuccino))
- Risolviamo le violazioni dividendo meglio le responsabilità, introducendo una classe dedicata per la macchinetta del caffè a pagamento. (branch [refactor/payments](https://github.com/xtreamsrl/java-solid-unicatt/tree/refactor/payment))

Nel nostro caso, applicare l'OCP comporta il porsi domande come 
1. "In futuro è possibile che ci siano altri tipi di macchinette che supportano altre bevande (cioccolata, té)?"
2. "In futuro è possibile che non solo la macchinetta del caffé sia a pagamento?"
3. "Tutte le bevande avranno lo stesso costo?"

### It's your turn!

Per rispondere alla prima domanda trovate un refactor iniziale nella branch [refactor/drink-machine](https://github.com/xtreamsrl/java-solid-unicatt/tree/refactor/drink-machine) con cui esercitarsi:  
- Individuare dove viene violato l'OCP e risolverlo (hint: ereditarietà)
- Supponiamo che la domanda 3 dia esito positivo: rendere la codebase sufficientemente flessibile per supportare tale modifica.
