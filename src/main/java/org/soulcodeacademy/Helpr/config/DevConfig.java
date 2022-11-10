package org.soulcodeacademy.Helpr.config;

import org.soulcodeacademy.Helpr.services.PopulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

// Ela é uma classe de configuração
// indica que essa classe será gerenciada pelo Spring
@Configuration
@Profile("dev") // Será instanciada apenas se o perfil ativo for "dev"
public class DevConfig {
    // Essa classe irá chamar o PopulateService caso o perfil ativo seja de desenvolvimento
    @Autowired // @palavra chave = anotação
    private PopulateService popularService;


    @Value("${spring.jpa.hibernate.ddl-auto}") // vai acessar a propriedade (lê as properties.)
    private String ddlAuto;


    // pós contruir o devconfig, executa o método abaixo
    @PostConstruct // faz com que o método execute após a instancia ser criada
    public void init(){
        System.out.println("Batata!");
        //se o modo for create, insere os dados ficticios
        if(this.ddlAuto.equals("create")){
            // insereos dados novos caso a tabela tenha sido dropada
            this.popularService.populate();
        }
    }
}
