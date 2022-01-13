function NavBar(){
    return(

<nav className="navbar navbar-expand-lg navbar-dark bg-dark">
  <div className="container-fluid">
    <a className="navbar-brand" href="/"><h2><center>COVID 19 Vaccination Information</center></h2></a>
    <img src="/webapplication-frontend/public/covid-safe-logo.png" alt="" width="30" height="24"/>
    
    
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNav">
     
    </div>
  </div>
</nav>

    )
}

export default NavBar;