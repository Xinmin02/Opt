import java.util.ArrayList;
import java.util.List;

// Persoon is een abstracte klasse die de gemeenschappelijke eigenschap "naam" heeft.
abstract class Persoon {
    private String naam;

    public Persoon(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
}

// Beheerder is een subklasse van Persoon.
class Beheerder extends Persoon {
    public Beheerder(String naam) {
        super(naam);
    }

    // Methode om een nieuw land toe te voegen.
    public void toevoegenLand(String landNaam, boolean isVeilig) {
        System.out.println("Land " + landNaam + " toegevoegd.");
    }

    // Methode om een nieuwe gemeente toe te voegen.
    public void toevoegenGemeente(String gemeenteNaam, int aantalInwoners) {
        System.out.println("Gemeente " + gemeenteNaam + " toegevoegd.");
    }
}

// COAMedewerker is een subklasse van Persoon.
class COAMedewerker extends Persoon {
    public COAMedewerker(String naam) {
        super(naam);
    }

    // Methode om een vluchteling te registreren.
    public void registreren(Vluchteling vluchteling) {
        System.out.println("Vluchteling " + vluchteling.getNaam() + " geregistreerd.");
    }

    // Methode om een gemeente op te vragen.
    public Gemeente gemeenteOpvragen(Vluchteling vluchteling) {
        System.out.println("Gemeente opgevraagd voor vluchteling " + vluchteling.getNaam());
        // Return een dummy gemeente, hier kun je de logica toevoegen om de gemeente op te vragen
        return new Gemeente("DummyGemeente", 1000);
    }
}

// Vluchteling is een subklasse van Persoon.
class Vluchteling extends Persoon {
    private String landVanHerkomst;
    private Dossier dossier;

    public Vluchteling(String naam, String landVanHerkomst) {
        super(naam);
        this.landVanHerkomst = landVanHerkomst;
        this.dossier = new Dossier();
    }

    public String getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public Dossier getDossier() {
        return dossier;
    }
}

// Dossier klasse om de status van de vluchteling bij te houden.
class Dossier {
    private boolean paspoortGetoond;
    private boolean asielaanvraagCompleet;
    private boolean rechterToegewezen;
    private String rechterUitspraak;
    private String plaatsingInEigenWoning;

    // Constructor
    public Dossier() {
        this.paspoortGetoond = false;
        this.asielaanvraagCompleet = false;
        this.rechterToegewezen = false;
        this.rechterUitspraak = "nee";
        this.plaatsingInEigenWoning = "nee";
    }

    // Getters en setters (niet nodig voor dit voorbeeld)
}

// Gemeente klasse om informatie over gemeenten op te slaan.
class Gemeente {
    private String naam;
    private int aantalInwoners;

    public Gemeente(String naam, int aantalInwoners) {
        this.naam = naam;
        this.aantalInwoners = aantalInwoners;
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalInwoners() {
        return aantalInwoners;
    }
}

public class Main {
    public static void main(String[] args) {
        // Voorbeeldgebruik van de klassen
        Beheerder beheerder = new Beheerder("Jan");
        COAMedewerker coaMedewerker = new COAMedewerker("Piet");
        Vluchteling vluchteling = new Vluchteling("test", "Syrië");

        // Testmethoden aanroepen
        beheerder.toevoegenLand("Nederland", true);
        beheerder.toevoegenGemeente("Amsterdam", 863202);
        coaMedewerker.registreren(vluchteling);
        Gemeente gemeente = coaMedewerker.gemeenteOpvragen(vluchteling);
        if (gemeente != null) {
            System.out.println("De asielzoeker kan geplaatst worden in gemeente: " + gemeente.getNaam());
        } else {
            System.out.println("Er zijn geen geschikte gemeentes beschikbaar.");
        }
    }
}