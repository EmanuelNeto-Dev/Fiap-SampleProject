# Fiap-SampleProject

Este repositório contém uma simples aplicação em Spring Boot para que possamos demonstrar em sua configuração e estrutura um pouco das Features utilizadas nos processos de DevOps e GitOps contando com a plataforma do Openshift + Docker. 

* Tecnologia
  * Java + Spring Boot
  * PostgreSQL

* Processo de Deploy a partir de um repositório de código via linha de Comando (openshift-cli)

  ```
  oc new-app java:11~https://github.com/EmanuelNeto-Dev/Fiap-SampleProject --name fiap-sample-parking-control-api
  oc expose svc/fiap-sample-parking-control-api
  ```

* Processo de Deploy a partir de um WebConsole no Openshift
 
  1. Log in to the OpenShift web console.
  
  2. Clique em *New Project*, insira os detalhes de NAME, DISPLAY NAME e DESCRIÇÃO nos campos correspondentes e então clique em CREATE
  
  3. Selecione o modo de Deploy de Imagem via GIT SOURCE CODE e informe os detalhes do caminho do repositório, diretório raiz da aplicação onde se encontra a imagem e os binários gerados da compilação JAVA e então clique em CREATE
     * Caso a imagem da aplicação não seja reconhecida automaticamente, informe ao Openshift que deverá utilizar um template de aplicação JAVA *
  
  4. Aguarde o Build finalizar.
     * Poderá acontecer de a aplicação já utilizar libs do PostgreSQL e por isso, apresentar erros na inicialização. Porém após gerar a imagem da base de dados, efetuar deploy com as devidas configurações de acesso utilizando das variáveis já exisstentes na aplicação, estes erros irão sumir e a aplicação funcionará normalmente. *
      
 
