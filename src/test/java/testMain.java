/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import datos.Polera;
import com.mycompany.alvarez_2.alvarez2;

/**
 *
 * @author JAVIER
 */
public class testMain {

    @Test
    public void testSeparar() {
        assertEquals("material", alvarez2.separarPedidos(alvarez2.readFile("listado.csv"))[0]);
        assertEquals("polyester", alvarez2.separarPedidos(alvarez2.readFile("listado.csv"))[3]);
        assertEquals("L", alvarez2.separarPedidos(alvarez2.readFile("listado.csv"))[13]);
        assertEquals("M", alvarez2.separarPedidos(alvarez2.readFile("listado.csv"))[16]);
        assertEquals("algodon", alvarez2.separarPedidos(alvarez2.readFile("listado.csv"))[6]);

    }
}
