import junit.framework.*;

import static org.assertj.core.api.Assertions.*;

public class myTest{

  public void testCalculer() throws Exception {

    Forme e = new Elipse(0,0,100,100);
    assertThat(e.aire , Math.PI * 50 * 50);
  }
}