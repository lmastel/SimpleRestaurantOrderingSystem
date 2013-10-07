/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author LPM
 */
public class StartupServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String dailySpecial = sc.getInitParameter("dailySpecial");
        sc.setAttribute("dailySpecial", dailySpecial);
//        Dog d = new Dog(dogBreed);
//        sc.setAttribute("dog", d);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
