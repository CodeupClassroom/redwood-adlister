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

### Extra JDBC practice.

- Create a search bar in your adlister that search in your database for ads that look like the term you typed in the title or description columns.

#### Hints:

- You will have to create a servlet, another method in the Ads interface, implement the new method in the AdsMySQLDao for this functionality to work.  You can show the filtered results in the /ads page.