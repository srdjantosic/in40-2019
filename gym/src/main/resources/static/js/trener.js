$(document).ready(function () {    
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/trener",                 
        dataType: "json",                                          
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    

            for (let trener of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + trener.ime + "</td>";       
                row += "<td>" + trener.prezime+ "</td>";
                row += "<td>" + trener.korisnicko_ime+ "</td>";
                row += "<td>" + trener.lozinka+ "</td>";
                row += "<td>" + trener.datum_rodjenja+ "</td>";
                row += "<td>" + trener.kontakt+ "</td>";
                row += "<td>" + trener.email + "</td>";  
                row += "<td>" + trener.aktivan+ "</td>";
                btn = "<button class='btnDelet' data-id=" + trener.korisnicko_ime+ ">Delete</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";                                    

                $('#treneri').append(row);                      
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.btnDelet', function () {
    let id = this.dataset.id;
    console.log(id);
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/trener/" + id,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + id + '"]').parent().parent().remove();  // ukloni red tabele u kom se nalazi element sa data-id atributom = employeeId
        },
        error: function () {
            alert("Greška prilikom brisanja fitness centra!");
        }
    });
});
   