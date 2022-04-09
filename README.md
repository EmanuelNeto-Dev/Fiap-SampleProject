# Fiap-SampleProject

Este repositório contém uma simples aplicação em Spring Boot para que possamos demonstrar em sua configuração e estrutura um pouco das Features utilizadas nos processos de DevOps e GitOps contando com a plataforma do Openshift + Docker. 

* Tecnologia
  * Java + Spring Boot
  * PostgreSQL

## ADDING AND DEPLOYING JAVA + SPRING BOOT APPLICATION

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
      
 
## ADDING A POSTGRESQL DATABASE

* Adicionando uma base de dados PostgreSQL através da linha de comando
  1. Para efetuar o deploy de uma base de dados PostgreSQL utilizando a linha de comando
    ```
    oc new-app  postgresql-persistent --name parking-control-db --param DATABASE_SERVICE_NAME=postgresql
  
    ```
  2. Para configurar a aplicação já existente e já exposta para acessar e utilizar a base de dados que irá ser adicionada ao Openshift, deverão ser setados novos valores para as variáveis de ambiente existentes no arquivo de configuração existentes na aplicação.
    ```
    oc set env dc\fiap-sample-parking-control-api spring.datasource.url=jdbc:postgresql://postgresql:5432/parking-control-db 
    oc set env dc\fiap-sample-parking-control-api spring.datasource.username=emanuel
    oc set env dc\fiap-sample-parking-control-api spring.datasource.password=root
    ```
  3. Para criar novos usuários que sejam compatíveis com a string de conexão exposta e informada no serviço já existente, basta acessar o terminal disponível no serviço de banco de dados e executar a estrutura de códigos que segue abaixo:
  
    ```
    psql postgres
    CREATE ROLE emanuel WITH LOGIN PASSWORD 'root';
    CREATE ROLE
    ALTER ROLE emanuel Superuser;
    ALTER ROLE
    \q
    ```
