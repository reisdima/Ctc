# Objetivo

Esse repositório é a resolução dos três desafios da empresa [CTC](http://example.net/)

## Palíndromo

"Faça um algoritmo em Java que verifique se uma String é Palíndromo. Um diferencial é
receber um argumento se deseja que a comparação seja case sensitive ou não, e se deve
ignorar os espaços;"


Existem dois modos de execução: por escrita ou por leitura de arquivo, em que cada linha é uma palavra. O arquivo de leitura já existe com alguns exemplos.
Criei um menu por linha de comando, sem nenhum parâmetro de inicialização de arquivo. Fiz isso por achar que haviam muitas opções, e 
que ficaria melhor configurar isso com o programa executando

## K-Complementary Pairs

"Escreva um algoritmo eficiente, para encontrar “K-Complementary Pairs”. Dado um array
A, e um inteiro K o par (i, j) é um K-Complementary se K = A[i] + A[J]. Um diferencial será
informar o Big-O do algoritmo;"

Não consegui pensar numa boa maneira de permitir testes mais complexos. Espero que apenas o algoritmo seja suficiente.

## Frases mais frequentes

"Dado um arquivo texto muito grande, que não caiba na memória — exemplo: 100 GB —
encontre as 50 mil frases mais frequentes. O formato do arquivo são Linhas com até 50
frases divididas por pipe. Faz parte da questão gerar o arquivo."

O arquivo que está sendo gerado está por volta de 100MB. O algoritmo consiste em ler um arquivo com frases, gerar um novo arquivo repetindo essas frases no formato
solicitado. Depois, é feita a leitura do arquivo gerado para contar a ocorrência das frases. Por fim e escrito em um arquivo de saída o resultado das contagens.
Não consegui pensar numa maneira de criar um arquivo tão grande, com tantas frases distintas.
