/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

/**
 *
 * @author IFPB
 */
public class NovoClass {
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687",AuthTokens.basic("neo4j","123"));
      
       try( Session session = driver.session()){
          
           /*
           StatementResult result = session.run(
           "create (p:produto ({codigo:$codigo,"
                   + "descricao:$descicao,"
                   + "preco:$preco} return id(p)",
                   Values.parameters("codigo",2,"descricao","feijao","preco",3));
           
          StatementResult resulta = null;
          while(resulta.hasNext()){
              Record recorde = resulta.next();
              System.out.println(recorde.get("p.codigo"));
          }
          StatementResult resulta = session.run(
           "match (p:produto)"
                   + "where p.codigo = $codigo"
                   + "return p.descricao as descriçao,"
                   + "p.preco as preco",
                  Values.parameters("codigo",1)); 
           */
           
          StatementResult rs = session.run("create ( p:produto {codigo:$codigo}) ",Values.parameters("codigo",2));
          StatementResult rs1 = session.run("match ( p:produto),(p2:produto) where p.codigo = $codigo and p2.codigo = $codigo2 "
                  + "create (p)-[r:teste]->(p2)",
                  Values.parameters("codigo",2,"codigo2",1));
          
          
          
       }finally{
           driver.close();
       }
       
    }
  
}
