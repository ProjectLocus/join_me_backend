# Join Me Backend

## HTTP://http://joinme.us-east-2.elasticbeanstalk.com/rest

Restful API for Join Me



**Version** v1














# APIs


<table>
  <thead>
  <tr>
    <th>Path</th>
    <th>Method</th>
    <th>Summary</th>
  </tr>
  </thead>
  <tbody>
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/invitations</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets all invitations.</a></td></tr>
      
      
      
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/invitations/{invitationId}</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getSingleInvitation">Gets an invitation.</a></td></tr>
      
      
      
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/people</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets all Person objects.</a></td></tr>
      
      <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Adds person.</a></td></tr>
      
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/people/{personId}</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get">Gets a person.</a></td></tr>
      <tr><td>&nbsp;</td><td><code>PUT</code></td><td><a href="#updatePerson">Updates a person.</a></td></tr>
      
      <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#deletePerson">Deletes a person.</a></td></tr>
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/people/{personId}/invitations</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getAllInvitationsPerPerson">Gets all new invitations for a person.</a></td></tr>
      
      <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#addInvitation">Adds an invitation to a person.</a></td></tr>
      
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/people/{personId}/invitations/{invitationId}</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getInvitationPerPerson">Gets a single invitation.</a></td></tr>
      <tr><td>&nbsp;</td><td><code>PUT</code></td><td><a href="#updateInvitation">Updates an invitation.</a></td></tr>
      
      
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/people/{personId}/people</strong></th>
    </tr>
    
      
      <tr><td>&nbsp;</td><td><code>PUT</code></td><td><a href="#getPeopleNearby">Updates a person&#x27;s location and gets the people near them.</a></td></tr>
      
      
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/squares</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets all squares.</a></td></tr>
      
      <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Initializes squares.</a></td></tr>
      
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/squares/{squareId}</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get">Gets a square.</a></td></tr>
      
      
      <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete">Deletes a square.</a></td></tr>
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/squares/{squareId}/vertices</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#vertexList">Gets vertices associated with a square.</a></td></tr>
      
      <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#postVertex">Adds square to vertex.</a></td></tr>
      
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/squares/{squareId}/vertices/{vertexId}</strong></th>
    </tr>
    
      
      
      
      <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#deleteVertex">Removes a vertex from a square.</a></td></tr>
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/vertices</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets all vertices.</a></td></tr>
      
      <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Initializes vertices in a new database.</a></td></tr>
      
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/vertices/{vertexId}</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getHTML"></a></td></tr>
      
      
      <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete">Deletes a vertex.</a></td></tr>
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/vertices/{vertexId}/squares</strong></th>
    </tr>
    
      <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#squareList">Gets the squares associated with a vertex.</a></td></tr>
      
      <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#postSquare">Adds squares to a vertex.</a></td></tr>
      
      
      
      
    
  
    <tr>
      <th colspan="3" style="text-align: left;"><strong>/vertices/{vertexId}/squares/{squareId}</strong></th>
    </tr>
    
      
      
      
      <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#deleteSquare">Deletes a square from a vertex.</a></td></tr>
      
      
      
    
  
  </tbody>
</table>


  ## /invitations
  

    
      ### <a name="list"></a>GET
      
Gets all invitations.

Retrieves all invitations from/to all people.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Invitation">Invitation</a>]|

    

    

    

    

    

    

    <a name=""></a>

  

  ## /invitations/{invitationId}
  

    
      ### <a name="getSingleInvitation"></a>GET
      
Gets an invitation.

Retrieves the invitation for the given invitationId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>invitationId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the invitation.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Invitation">Invitation</a>|

    

    

    

    

    

    

    <a name=""></a>

  

  ## /people
  

    
      ### <a name="list"></a>GET
      
Gets all Person objects.

Retrieves all people.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Person">Person</a>]|

    

    

    
      ### <a name="post"></a>POST
      
Adds person.

Adds person to database.







#### Request


  **Content-Type:** application/json



  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>body</strong></td>
      <td>body</td>
      <td>yes</td>
      <td>Partial person object.</td>
      <td></td>
      
        <td>
          
          <a href="#/definitions/Person">Person</a> 
        </td>
      
    </tr>


  </table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Person">Person</a>|

    

    

    

    

    <a name=""></a>

  

  ## /people/{personId}
  

    
      ### <a name="get"></a>GET
      
Gets a person.

Retrieves a person according to personId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>personId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the person.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Person">Person</a>|

    

    
      ### <a name="updatePerson"></a>PUT
      
Updates a person.

Updates a person according to personId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>body</strong></td>
      <td>body</td>
      <td>yes</td>
      <td>Person object.</td>
      <td></td>
      
        <td>
          
          <a href="#/definitions/Person">Person</a> 
        </td>
      
    </tr>

    <tr>
      <td><strong>personId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the person.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Person">Person</a>|

    

    

    
      ### <a name="deletePerson"></a>DELETE
      
Deletes a person.

Deletes a person according to personId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>personId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the person.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| default    | successful operation |  - |

    

    

    

    <a name=""></a>

  

  ## /people/{personId}/invitations
  

    
      ### <a name="getAllInvitationsPerPerson"></a>GET
      
Gets all new invitations for a person.

Retrieves all new invitation for a person according to personId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>personId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the person.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Invitation">Invitation</a>]|

    

    

    
      ### <a name="addInvitation"></a>POST
      
Adds an invitation to a person.

Adds an invitation to a person according to personId.







#### Request


  **Content-Type:** application/json



  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>personId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the person.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>

    <tr>
      <td><strong>body</strong></td>
      <td>body</td>
      <td>yes</td>
      <td>Invitation object.</td>
      <td></td>
      
        <td>
          
          <a href="#/definitions/Invitation">Invitation</a> 
        </td>
      
    </tr>


  </table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Invitation">Invitation</a>|

    

    

    

    

    <a name=""></a>

  

  ## /people/{personId}/invitations/{invitationId}
  

    
      ### <a name="getInvitationPerPerson"></a>GET
      
Gets a single invitation.

Retrieves a single invitation associated with a person, according to personId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>invitationId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the invitation.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Invitation">Invitation</a>|

    

    
      ### <a name="updateInvitation"></a>PUT
      
Updates an invitation.

Updates a single person&#x27;s id, based on personId and invitationId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>invitationId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the invitation.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Invitation">Invitation</a>|

    

    

    

    

    

    <a name=""></a>

  

  ## /people/{personId}/people
  

    

    
      ### <a name="getPeopleNearby"></a>PUT
      
Updates a person&#x27;s location and gets the people near them.

Causes a person&#x27;s location to be updated and retrieves a list of all the people that are near the new location.







#### Request


  **Content-Type:** application/json



  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>body</strong></td>
      <td>body</td>
      <td>yes</td>
      <td>Person object.</td>
      <td></td>
      
        <td>
          
          <a href="#/definitions/Person">Person</a> 
        </td>
      
    </tr>

    <tr>
      <td><strong>personId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the person.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Person">Person</a>]|

    

    

    

    

    

    <a name=""></a>

  

  ## /squares
  

    
      ### <a name="list"></a>GET
      
Gets all squares.

Retrieves all squares in the database.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Square">Square</a>]|

    

    

    
      ### <a name="post"></a>POST
      
Initializes squares.

Causes pre-set squares to be added to the database. After a database wipe, this must be the first thing added to a new database.







#### Request


  **Content-Type:** application/json







#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Square">Square</a>]|

    

    

    

    

    <a name=""></a>

  

  ## /squares/{squareId}
  

    
      ### <a name="get"></a>GET
      
Gets a square.

Retrieves a square according to squareId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>squareId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the square.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Square">Square</a>|

    

    

    

    
      ### <a name="delete"></a>DELETE
      
Deletes a square.

Deletes a square according to squareId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>squareId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the square.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    |  |  - |

    

    

    

    <a name=""></a>

  

  ## /squares/{squareId}/vertices
  

    
      ### <a name="vertexList"></a>GET
      
Gets vertices associated with a square.

Retrieves the vertices associated with a squareId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>squareId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the square.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Vertex">Vertex</a>]|

    

    

    
      ### <a name="postVertex"></a>POST
      
Adds square to vertex.

Adds the square, by squareId, to the passed vertex.







#### Request


  **Content-Type:** application/json



  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>squareId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the square.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>

    <tr>
      <td><strong>body</strong></td>
      <td>body</td>
      <td>yes</td>
      <td>Vertex object.</td>
      <td></td>
      
        <td>
          
          <a href="#/definitions/Vertex">Vertex</a> 
        </td>
      
    </tr>


  </table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Square">Square</a>|

    

    

    

    

    <a name=""></a>

  

  ## /squares/{squareId}/vertices/{vertexId}
  

    

    

    

    
      ### <a name="deleteVertex"></a>DELETE
      
Removes a vertex from a square.

Deletes a vertex from a square, according to vertexId and squareId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>squareId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the square.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>

    <tr>
      <td><strong>vertexId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td>Id for the vertex.</td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    |  |  - |

    

    

    

    <a name=""></a>

  

  ## /vertices
  

    
      ### <a name="list"></a>GET
      
Gets all vertices.

Retrieves all vertices in the database.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Vertex">Vertex</a>]|

    

    

    
      ### <a name="post"></a>POST
      
Initializes vertices in a new database.

Initializes vertices in a new database. This is the second operation that must be performed after wiping a database.  Squares should always be initialized first, and people and invitations should not be added until both squares and vertices are already present (in that order).







#### Request


  **Content-Type:** application/json







#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Vertex">Vertex</a>|

    

    

    

    

    <a name=""></a>

  

  ## /vertices/{vertexId}
  

    
      ### <a name="getHTML"></a>GET
      










#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>vertexId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td></td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response

**Content-Type:** text/html


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | |

    

    

    

    
      ### <a name="delete"></a>DELETE
      
Deletes a vertex.

Deletes a vertex, according to vertexId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>vertexId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td></td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    |  |  - |

    

    

    

    <a name=""></a>

  

  ## /vertices/{vertexId}/squares
  

    
      ### <a name="squareList"></a>GET
      
Gets the squares associated with a vertex.

Gets the squares associated with a vertex, according to vertexId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>vertexId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td></td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Square">Square</a>]|

    

    

    
      ### <a name="postSquare"></a>POST
      
Adds squares to a vertex.

Adds squares to a vertex, according to vertexId.







#### Request


  **Content-Type:** application/json



  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>vertexId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td></td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>

    <tr>
      <td><strong>body</strong></td>
      <td>body</td>
      <td>no</td>
      <td></td>
      <td></td>
      
        <td>
          
          <a href="#/definitions/Vertex">Vertex</a> 
        </td>
      
    </tr>


  </table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/Square">Square</a>|

    

    

    

    

    <a name=""></a>

  

  ## /vertices/{vertexId}/squares/{squareId}
  

    

    

    

    
      ### <a name="deleteSquare"></a>DELETE
      
Deletes a square from a vertex.

Deletes a square from a vertex, according to squareId and vertexId.







#### Request





  ##### Parameters

  <table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Located in</th>
      <th>Required</th>
      <th>Description</th>
      <th>Default</th>
      <th>Schema</th>
    </tr>



    <tr>
      <td><strong>vertexId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td></td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>

    <tr>
      <td><strong>squareId</strong></td>
      <td>path</td>
      <td>yes</td>
      <td></td>
      <td></td>
      
        
          <td>integer (int64)</td>
        
      
    </tr>


  </table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    |  |  - |

    

    

    

    <a name=""></a>

  


# Definitions

  ## <a name="/definitions/Invitation">Invitation</a>

  <table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Type</th>
      <th>Mode</th>
      <th>Description</th>
      <!--<th>Example</th>-->
    </tr>
    
      <tr>
        <td><strong>id</strong></td>
        <td>
          
            
            integer (int64)
          
        </td>
        <td>
          required
        </td>
        <td>invitation_id</td>
        <!--<td>111</td>-->
      </tr>
    
      <tr>
        <td><strong>userSenderId</strong></td>
        <td>
          
            
            integer (int64)
          
        </td>
        <td>
          required
        </td>
        <td>user_sender_id</td>
        <!--<td>13</td>-->
      </tr>
    
      <tr>
        <td><strong>userReceiverId</strong></td>
        <td>
          
            
            integer (int64)
          
        </td>
        <td>
          required
        </td>
        <td>user_receiver_id</td>
        <!--<td>2</td>-->
      </tr>
    
      <tr>
        <td><strong>wasDelivered</strong></td>
        <td>
          
            
            boolean
          
        </td>
        <td>
          required
        </td>
        <td>was_delivered</td>
        <!--<td>false</td>-->
      </tr>
    
      <tr>
        <td><strong>willAttend</strong></td>
        <td>
          
            
            boolean
          
        </td>
        <td>
          required
        </td>
        <td>will_attend</td>
        <!--<td>false</td>-->
      </tr>
    
      <tr>
        <td><strong>degreesRemaining</strong></td>
        <td>
          
            
            integer (int32)
          
        </td>
        <td>
          optional
        </td>
        <td>degrees_remaining</td>
        <!--<td>The number of times the invitation can be reused.</td>-->
      </tr>
    
      <tr>
        <td><strong>date</strong></td>
        <td>
          
            
            string
          
        </td>
        <td>
          required
        </td>
        <td>date</td>
        <!--<td>A string representation of the date for the really fun event.</td>-->
      </tr>
    
      <tr>
        <td><strong>description</strong></td>
        <td>
          
            
            string
          
        </td>
        <td>
          required
        </td>
        <td>description</td>
        <!--<td>This is a description of the really fun event someone is being invited to attend.</td>-->
      </tr>
    
      <tr>
        <td><strong>title</strong></td>
        <td>
          
            
            string
          
        </td>
        <td>
          required
        </td>
        <td>title</td>
        <!--<td>This is the title of my invitation.</td>-->
      </tr>
    
      <tr>
        <td><strong>location</strong></td>
        <td>
          
            
            string
          
        </td>
        <td>
          required
        </td>
        <td>location</td>
        <!--<td>A string representation of the location of the event.</td>-->
      </tr>
    
      <tr>
        <td><strong>people</strong></td>
        <td>
          
            
              array[<a href="#/definitions/Person">Person</a>]
            
            
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
      <tr>
        <td><strong>href</strong></td>
        <td>
          
            
            string (uri)
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
  </table>

  ## <a name="/definitions/Person">Person</a>

  <table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Type</th>
      <th>Mode</th>
      <th>Description</th>
      <!--<th>Example</th>-->
    </tr>
    
      <tr>
        <td><strong>personId</strong></td>
        <td>
          
            
            integer (int64)
          
        </td>
        <td>
          required
        </td>
        <td>person_id</td>
        <!--<td>1</td>-->
      </tr>
    
      <tr>
        <td><strong>closestVertex</strong></td>
        <td>
          
            <a href="#/definitions/Vertex">Vertex</a>
            
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
      <tr>
        <td><strong>invitations</strong></td>
        <td>
          
            
              array[<a href="#/definitions/Invitation">Invitation</a>]
            
            
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
      <tr>
        <td><strong>latitude</strong></td>
        <td>
          
            
            number (double)
          
        </td>
        <td>
          required
        </td>
        <td>latitude</td>
        <!--<td>35.0855</td>-->
      </tr>
    
      <tr>
        <td><strong>longitude</strong></td>
        <td>
          
            
            number (double)
          
        </td>
        <td>
          required
        </td>
        <td>longitude</td>
        <!--<td>-106.6497</td>-->
      </tr>
    
      <tr>
        <td><strong>currentSquare</strong></td>
        <td>
          
            <a href="#/definitions/Square">Square</a>
            
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
      <tr>
        <td><strong>displayName</strong></td>
        <td>
          
            
            string
          
        </td>
        <td>
          required
        </td>
        <td>display_name</td>
        <!--<td>ARne arNEssoN</td>-->
      </tr>
    
      <tr>
        <td><strong>userImageLocation</strong></td>
        <td>
          
            
            string
          
        </td>
        <td>
          required
        </td>
        <td>user_image_location</td>
        <!--<td>https://myimagehere.com</td>-->
      </tr>
    
      <tr>
        <td><strong>userDescription</strong></td>
        <td>
          
            
            string
          
        </td>
        <td>
          required
        </td>
        <td>user_description</td>
        <!--<td>This is me. I like coffee. I like dogs. I don&#x27;t like tater-tots.</td>-->
      </tr>
    
      <tr>
        <td><strong>googleUserId</strong></td>
        <td>
          
            
            string
          
        </td>
        <td>
          required
        </td>
        <td>google_id</td>
        <!--<td>123234345456567</td>-->
      </tr>
    
      <tr>
        <td><strong>href</strong></td>
        <td>
          
            
            string (uri)
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
  </table>

  ## <a name="/definitions/Square">Square</a>

  <table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Type</th>
      <th>Mode</th>
      <th>Description</th>
      <!--<th>Example</th>-->
    </tr>
    
      <tr>
        <td><strong>id</strong></td>
        <td>
          
            
            integer (int64)
          
        </td>
        <td>
          required
        </td>
        <td>square_id</td>
        <!--<td>3</td>-->
      </tr>
    
      <tr>
        <td><strong>latitudeLowerBound</strong></td>
        <td>
          
            
            number (double)
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
      <tr>
        <td><strong>latitudeUpperBound</strong></td>
        <td>
          
            
            number (double)
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
      <tr>
        <td><strong>longitudeLowerBound</strong></td>
        <td>
          
            
            number (double)
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
      <tr>
        <td><strong>longitudeUpperBound</strong></td>
        <td>
          
            
            number (double)
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
      <tr>
        <td><strong>people</strong></td>
        <td>
          
            
              array[<a href="#/definitions/Person">Person</a>]
            
            
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
      <tr>
        <td><strong>vertices</strong></td>
        <td>
          
            
              array[<a href="#/definitions/Vertex">Vertex</a>]
            
            
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
      <tr>
        <td><strong>href</strong></td>
        <td>
          
            
            string (uri)
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
  </table>

  ## <a name="/definitions/Vertex">Vertex</a>

  <table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
      <th>Name</th>
      <th>Type</th>
      <th>Mode</th>
      <th>Description</th>
      <!--<th>Example</th>-->
    </tr>
    
      <tr>
        <td><strong>id</strong></td>
        <td>
          
            
            integer (int64)
          
        </td>
        <td>
          required
        </td>
        <td>vertex_id</td>
        <!--<td>1</td>-->
      </tr>
    
      <tr>
        <td><strong>latitude</strong></td>
        <td>
          
            
            number (double)
          
        </td>
        <td>
          required
        </td>
        <td>latitude</td>
        <!--<td>35.0855</td>-->
      </tr>
    
      <tr>
        <td><strong>longitude</strong></td>
        <td>
          
            
            number (double)
          
        </td>
        <td>
          required
        </td>
        <td>longitude</td>
        <!--<td>-106.64955</td>-->
      </tr>
    
      <tr>
        <td><strong>squares</strong></td>
        <td>
          
            
              array[<a href="#/definitions/Square">Square</a>]
            
            
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
      <tr>
        <td><strong>href</strong></td>
        <td>
          
            
            string (uri)
          
        </td>
        <td>
          optional
        </td>
        <td>-</td>
        <!--<td></td>-->
      </tr>
    
  </table>
