import React from 'react';
import { makeStyles, createMuiTheme, ThemeProvider } from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';


import LoginForm from './components/LoginForm'
import SignupForm from './components/SignupForm';
import UploadPage from './uploadpage';

import { useHistory, BrowserRouter as Router, Route, Switch } from 'react-router-dom';




const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    flexGrow: 1,
    height: '100vh',
    overflow: 'auto',
    width: '2000px',
  },
  signupButton: {
    height: '70px',
    width: '200px',
  },
}));


function AppRouter() {
  const classes = useStyles();
  const history = useHistory();
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
         <br/>
        
        
          
        
        </Route>
        <Route path="/uploadpage" component={UploadPage} />
        
        </div>
      </Switch>
   
    </Router>
      
  );
}

export default AppRouter;
