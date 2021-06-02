// Dodavanje novog zaposlenog
$(document).on("submit", "#RegistracijaForm", function (event) {     // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let ime = $("#ime").val();
    let prezime = $("#prezime").val();
    let korisnicko_ime = $("#korisnicko_ime").val();
    let email = $("#email").val();
    let password = $("#password").val();
    let datum_rodjenja = $("#datum_rodjenja").val();
    let kontakt = $("#kontakt").val();
    // kreiramo objekat zaposlenog
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
    let newClan = {
        ime,
        prezime,
        korisnicko_ime,
        email,
        password,
        datum_rodjenja,
        kontakt     // zbog backend-a jobPosition moramo preimenovati u atribut position
    }
    
    // ajax poziv za kreiranje novog zaposlenog na backend-u
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/clan",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(newClan),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Clan " + response.id + " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
            window.location.href = "RegistracijaKorisnika.html";                // redirektujemo ga na employees.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja korisnika!");
        }
    });
});