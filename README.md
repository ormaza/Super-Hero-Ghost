# Super Hero Ghost

### Descrição
Super Hero Ghost é um mini game desenvolvido em Java utilizando elementos da API gráfica Swing. No jogo, um spin-off do universo Mario, o jogador controlará o nosso anti-herói Boo. Seu objetivo é comer o maior numero de maçãs, enquanto desvia das minas que aparecem pelo caminho.

<p align="center"><img src="https://github.com/ormaza/ormaza.github.io/blob/master/Super%20Hero%20Ghost/screenshot.png"></p>

### Como executar
-Instalar o Java <br>
-Executar <a href="https://github.com/ormaza/Super-Hero-Ghost/blob/master/binary/Super%20Hero%20Ghost.exe">Super Hero Ghost</a>

### Documentação
Atores são os componentes do jogo que executam alguma ação. Nesse jogo, as ações seriam a colisão entre o player e a maçã, resultado em aumento da pontuação, e entre o player e a mina, resultando em fim de jogo. Por serem objetos de ação, todos os atores são do tipo JButton. A colisão é detectada quando, basicamente, os dois atores estiverem ocupando as mesmas posições.

<p align="center"><img src="https://github.com/ormaza/ormaza.github.io/blob/master/Super%20Hero%20Ghost/atores.png"></p>

Para movimentar os atores foi utilizada uma thread, numa taxa de atualizaçao de 30 vezes por segundo. A cada atualização, o jogo é redesenhado e os atores assumem novas posições, calculadas pelo método velocidade(). Essa rotina dá a sensação de fluidez dos atores no cenário. Ao morrer, o player insere seu nome e sua pontuação numa lista ordenada de recordes. Essa lista é reordenada a cada fim de jogo usando o algoritmo Insertion sort. Na versão 
