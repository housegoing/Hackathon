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
    
    
    const emailRef = React.createRef<HTMLInputElement>();
    const passwordRef = React.createRef<HTMLInputElement>();
    const nameRef = React.createRef<HTMLInputElement>();
    const [error, setError] = React.useState(' ');
    const [nameError, setNameError] = React.useState(false);
    const [emailError, setEmailError] = React.useState(false);
    const [passwordError, setPasswordError] = React.useState(false);
    const [signupText, setSignupText] = React.useState('Signup');
    const [loading, setLoading] = React.useState(false);
  
    const handleSignUp = () => {
        console.log("signup...");
    }
  


    return (
      <React.Fragment>
        <CssBaseline />
        <form>
          <TextField
            className={classes.textField}
            error={nameError}
            inputRef={nameRef}
            label="First Name"
            required
            size="small"
            autoFocus
            variant="outlined"
            margin="normal"
          />
          <TextField
            className={classes.textField}
            error={nameError}
            inputRef={nameRef}
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
            disabled={loading}
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
            disabled={loading}
            onKeyDown={handleSignUp}
          />
          <Button
            type="submit"
            size="small"
            variant="contained"
            color="primary"
            className={classes.button}
            onClick={handleSignUp}
            disabled={loading}
          >
            {signupText}
          </Button>
        </form>
      </React.Fragment>
    )
  }
  
  export default SignupForm;