$(document).ready(function () {    
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/termin",                 
        dataType: "json",                                          
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    

            for (let termin of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + termin.datum + "</td>";       
               
                btn = "<button class='btnBris' data-id=" + termin.id+ ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";                                    

                $('#termini').append(row);                      
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.btnBris', function () {
    let terminId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/termin/" + terminId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + terminId + '"]').parent().parent().remove();  // ukloni red tabele u kom se nalazi element sa data-id atributom = employeeId
        },
        error: function () {
            alert("Greška prilikom brisanja fitness centra!");
        }
    });
});