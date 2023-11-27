# Java RMI

Para rodar execute os comandos primeiro pela parte do cliente pelo RMIRegistry: 

```cmd
cd Client
javac *.java
rmiregistry 9400
```

Caso aconteça erros de não achar o `rmiregistry` verifique se as variáveis de ambiente contém no par chave e valor *path* o dirétorio que direciona ao /bin/ do java.

Continuando, execute agora o servidor em uma nova janela de execução:

```cmd
cd Server
javac *.java
java Server
```

Caso apareça no console 'Server On' então tudo está rodando.

Pós isso é só executar o cliente e utilizar do terminal a partir do comando em uma nova janela de execução:
```cmd
cd Client
java Client
```

# Descrição da solução:

A solução basicamente é de uma calculadora que consegue realizar os 4 cálculos básicos (somar, subtrair, multiplicar e dividir), para isso foi implementado uma interface chamada de ‘Calculator’ que a partir de sua implementação fará o que for pedido.
Por parte do cliente foi criado um menu de opções, onde ele pode escolher qual operação realizar, além de também ter o input dos dados via terminal.

