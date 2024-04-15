import static org.junit.Assert.*;
import org.junit.Test;


public class Junittest {

    @Test
    public void testToevoegenLand() {
        Beheerder beheerder = new Beheerder("Jan");
        beheerder.toevoegenLand("Nederland", true);
        assertTrue(beheerder.getLanden().contains("Nederland"));
    }

    @Test
    public void testToevoegenGemeente() {
        Beheerder beheerder = new Beheerder("Jan");
        beheerder.toevoegenGemeente("Amsterdam", 863202);
        assertTrue(beheerder.getGemeentes().contains("Amsterdam"));
    }

    @Test
    public void testRegistreren() {
        COAMedewerker coaMedewerker = new COAMedewerker("Piet");
        Vluchteling vluchteling = new Vluchteling("test", "Syrië");
        coaMedewerker.registreren(vluchteling);
        assertTrue(coaMedewerker.getGeregistreerdeVluchtelingen().contains(vluchteling));
    }

    @Test
    public void testGemeenteOpvragen() {
        COAMedewerker coaMedewerker = new COAMedewerker("Piet");
        Vluchteling vluchteling = new Vluchteling("test", "Syrië");
        Gemeente gemeente = coaMedewerker.gemeenteOpvragen(vluchteling);
        assertNotNull(gemeente);
    }
}