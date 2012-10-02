package fr.lau.kiriata.springrestlet;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * utilise le "hack"
 * Tu fais une classe mère pour toutes tes ressources
 * dedans tu mets tous les dao dont tu peux avoir besoin pour le poc
 * et tu les initialises dans le constructeur
 */
public class ApplicationContextHolder implements ApplicationContextAware {

    /**
     * Contexte Spring qui sera injecte par Spring directement
     */
    private static ApplicationContext context = null;

    /**
     * Méthode de ApplicationContextAware, qui sera appellée automatiquement par le conteneur
     */
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        context = ctx;
    }

    /**
     * Methode statique pour récupérer le contexte
     */
    public static ApplicationContext getContext() {
        return context;
    }

}