import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import controleur.AstuceControleur;


public class TestAstuceControleur {
	public class TestSimple {

	    @Test
	    public void calculerPourcentage() {
	    	AstuceControleur ac = new AstuceControleur();
	    	List<Float> listVal = ac.calculerPourcentage(2, 1, 1);
	        Assert.assertEquals(50.0,listVal.get(0) );
	    }

	}
}
