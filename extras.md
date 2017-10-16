### Servlet Bonus 

- Create a servlet and in the doGet method that takes a query string with 2 parameters and the first one determines the size of an Array and the second the value that fills the array, the response should print a HTML table that looks graphically like the array.

Request:

 `localhost:8080/fillArray?size=3&fill=Fer`

Response:

<table border=1 width="100%">
<tbody>
    <tr>
        <td>Fer</td>
        <td>Fer</td>
        <td>Fer</td>
    <tr>
</tbody>
</table>

- Bonus: Make it multidimensional