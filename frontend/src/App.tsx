import React from 'react';
import { makeStyles, createMuiTheme, ThemeProvider } from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';


import LoginForm from './components/LoginForm'
import SignupForm from './components/SignupForm';

import { useHistory } from 'react-router-dom';
import { BrowserRouter, Route, Switch } from 'react-router-dom';


const theme = createMuiTheme({
  palette: {
    primary: {
      main: '#1976d2',
    },
  },
});

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    flexGrow: 1,
    height: '100vh',
    overflow: 'auto',
  },
}));


function AppRouter() {
  const classes = useStyles();
  const history = useHistory();
  const [showSignForm, setShowSignForm] = React.useState(false);
  const [buttonContext, setButtonContext] = React.useState("Sign Up");
  
  const showSignup = () => {
    setShowSignForm(!showSignForm);
    setButtonContext(showSignForm ? "Login" : "Sign Up");
  }
  
  const afterLogin = () => {
    history.push('/uploadpage');

  }

  return (
    <BrowserRouter>
      <div className={classes.root}>
      <Button onClick={showSignup} > {buttonContext} </Button>
      {
        showSignForm ? <SignupForm /> : <LoginForm />
      }
      
      <Button onClick={afterLogin} > afterLogin </Button>
      </div>
    </BrowserRouter>
    
    
  );
}

export default AppRouter;
