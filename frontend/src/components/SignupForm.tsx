import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import CssBaseline from '@material-ui/core/CssBaseline';
import Button from '@material-ui/core/Button';
import { FormHelperText } from '@material-ui/core';

import { useHistory } from 'react-router-dom';
import axios, {AxiosResponse} from 'axios';

const useStyles = makeStyles((theme) => ({
    button: {
      margin: theme.spacing(1.5, 1, 1),
      paddingTop: '10px',
    
    },
    textField1: {
      marginLeft: theme.spacing(55),
      marginRight: theme.spacing(1),
      width: '25ch',
    },
    textField2: {
      marginLeft: theme.spacing(1),
      marginRight: theme.spacing(1),
      width: '25ch',
    },
    textField3: {
      marginLeft: theme.spacing(1),
      marginRight: theme.spacing(1),
      width: '25ch',
    },
    textField4: {
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
    const Publisher_URL = "http://localhost:8080/addPublisher";
  
    const handleSignUp = () => {
        try {
          console.log("signup...");
          history.push("/uploadpage");
          axios.post(Publisher_URL, {
                "email": emailRef.current?.value,
                "firstName": firstnameRef.current?.value,
                "lastName": lastnameRef.current?.value,
                "password": passwordRef.current?.value,
              })
        } catch (error) {
          console.log("error");
        }
    }
  
    return (
      <React.Fragment>
        <CssBaseline />
        <form>
          <TextField
            className={classes.textField1}
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
            className={classes.textField2}
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
            className={classes.textField3}
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
            className={classes.textField4}
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