package com.mujahed;

import java.security.Provider;
import java.security.Security;
import java.util.Iterator;
import java.util.Map;

/**
 * Java class to get all the available providers.
 */
public class App {
    public static void main(String[] args) {
        // dynamically register our bouncy castle provider
        // without requiring java.security modification
        //place the provided in the 11 position
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            System.out.println("********************");
            System.out.println("** Provider: " + provider.getName());
            System.out.println("********************");
            System.out.print(provider.toString());
            System.out.print(" is formally referred to as '" + provider.getName() + "'");
            System.out.println(" in a getInstance() factory method");
            System.out.println("");
            Iterator iterator = provider.entrySet().iterator();
            System.out.println("Listing providers supported Algorithms:");
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                // Listing providers supported Algorithms
                System.out.println("\t" + entry.getKey() + " = " + entry.getValue());
            }

            for (Provider.Service service : provider.getServices()) {
                System.out.println("  Algorithm: " + service.getAlgorithm());
            }
        }
        System.out.println("Total providers: " + providers.length);
    }
}
