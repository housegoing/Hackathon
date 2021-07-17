import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import CssBaseline from '@material-ui/core/CssBaseline';
import Button from '@material-ui/core/Button';
import { FormHelperText } from '@material-ui/core';

import { useHistory } from 'react-router-dom';

const useStyles = makeStyles((theme) => ({
    button: {
      margin: theme.spacing(1, 0, 1),
    },
    textField: {
      marginLeft: theme.spacing(1),
      marginRight: theme.spacing(1),
      width: '25ch',
    },
  }));
  

export const SignupForm = () => {
    const classes = useStyles();
    const history = useHistory();
    
    const emailRef = React.createRef<HTMLInputElement>();
    const passwordRef = React.createRef<HTMLInputElement>();
    const firstnameRef = React.createRef<HTMLInputElement>();
    const lastnameRef = React.createRef<HTMLInputElement>();
    const [error, setError] = React.useState(' ');
    const [firstNameError, setFirstNameError] = React.useState(false);
    const [lastNameError, setLastNameError] = React.useState(false);
    const [emailError, setEmailError] = React.useState(false);
    const [passwordError, setPasswordError] = React.useState(false);
    const [signupText, setSignupText] = React.useState('Signup');
    
  
    const handleSignUp = () => {
        console.log("signup...");
        history.push("/uploadpage");
    }
  
    return (
      <React.Fragment>
        <CssBaseline />
        <form>
          <TextField
            className={classes.textField}
            error={firstNameError}
            inputRef={firstnameRef}
            label="First Name"
            required
            size="small"
            autoFocus
            variant="outlined"
            margin="normal"
          />
          <TextField
            className={classes.textField}
            error={lastNameError}
            inputRef={lastnameRef}
            label="Last Name"
            required
            size="small"
            autoFocus
            variant="outlined"
            margin="normal"
          />
          <TextField
            className={classes.textField}
            error={emailError}
            inputRef={emailRef}
            label="Email"
            type="email"
            required
            size="small"
            variant="outlined"
            margin="normal"
            
          />
          <TextField
            className={classes.textField}
            error={passwordError}
            inputRef={passwordRef}
            label="Password"
            type="password"
            required
            size="small"
            variant="outlined"
            margin="normal"
            
            onKeyDown={handleSignUp}
          />
          <Button
            type="submit"
            size="small"
            variant="contained"
            color="primary"
            className={classes.button}
            onClick={handleSignUp}
            
          >
            {signupText}
          </Button>
        </form>
      </React.Fragment>
    )
  }
  
  export default SignupForm;