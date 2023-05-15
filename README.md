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

## Who we are
<img align="left" alt="xtream logo" width="80" height="80" src="https://avatars2.githubusercontent.com/u/38501645?s=450&u=1eb7348ca81f5cd27ce9c02e689f518d903852b1&v=4">
A proudly 🇮🇹 software development and data science startup.<br>We consider ourselves a family of talented and passionate people building their own products and powerful solutions for our clients. Get to know us more on <a target="_blank" href="https://xtreamers.io">xtreamers.io</a> or follow us on <a target="_blank" href="https://it.linkedin.com/company/xtream-srl">LinkedIn</a>.
