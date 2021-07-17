import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';


import LoginForm from './components/LoginForm'
import SignupForm from './components/SignupForm';
import UploadPage from './uploadpage';

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';




const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    flexGrow: 1,
    height: '100vh',
    overflow: 'auto',
    width: '2000px',
    flexDirection: "column",
  },
  signupButton: {
    height: '70px',
    width: '200px',
  },
}));


function AppRouter() {
  const classes = useStyles();
  const [showSignForm, setShowSignForm] = React.useState(false);
  const [logedin, setLogedin] = React.useState(false);
  
  const showSignup = () => {
    setShowSignForm(!showSignForm);
  }
  
  
  return (
    <Router>
      <Switch>
        <div className={classes.root}>
          
        <Route path="/">
          <Button className={classes.signupButton} onClick={showSignup} > {showSignForm ? "login" : "signup"} </Button>
            {
              showSignForm ? <SignupForm /> : <LoginForm />
            } 
        </Route>


        <div>
          <Route path="/uploadpage" component={UploadPage} />
        </div>

        </div>
      </Switch>
   
    </Router>
      
  );
}

export default AppRouter;
