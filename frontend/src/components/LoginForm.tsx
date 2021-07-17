import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import CssBaseline from "@material-ui/core/CssBaseline";
import Button from "@material-ui/core/Button";
import { FormHelperText } from "@material-ui/core";

import { useHistory } from "react-router-dom";
import { BrowserRouter, Route, Switch } from "react-router-dom";

const useStyles = makeStyles((theme) => ({
  button: {
    margin: theme.spacing(1.5, 1, 1),
    paddingTop: '10px',
    marginRight: theme.spacing(60),
  },
  textField1: {
    marginLeft: theme.spacing(90),
    marginRight: theme.spacing(2),
    width: '25ch',
  },
  textField2: {
    marginLeft: theme.spacing(2),
    marginRight: theme.spacing(4),
    width: '25ch',
  },
  loginform1: {
    width: '1800px',
  }
}));

export const LoginForm = () => {
  const classes = useStyles();
  const history = useHistory();

  const emailRef = React.createRef<HTMLInputElement>();
  const passwordRef = React.createRef<HTMLInputElement>();
  const nameRef = React.createRef<HTMLInputElement>();
  const [error, setError] = React.useState(" ");
  const [nameError, setNameError] = React.useState(false);
  const [emailError, setEmailError] = React.useState(false);
  const [passwordError, setPasswordError] = React.useState(false);
  const [signupText, setSignupText] = React.useState("Login");
  const [loading, setLoading] = React.useState(false);
  

  function handleLogin() {
    console.log("login...");
    //try {
    history.push("/uploadpage");

    // } catch (error) {
    //   console.log("error");
    // }
  }

  return (
    <React.Fragment>
      <CssBaseline />
      <form>
        <div className={classes.loginform1}>
        <TextField
          className={classes.textField1}
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
          className={classes.textField2}
          error={passwordError}
          inputRef={passwordRef}
          label="Password"
          type="password"
          required
          size="small"
          variant="outlined"
          margin="normal"
          disabled={loading}
          onKeyDown={handleLogin}
        />
        <Button
          type="submit"
          size="small"
          variant="contained"
          color="primary"
          className={classes.button}
          onClick={handleLogin}
          disabled={loading}
        >
          {signupText}
        </Button>
        </div>
      </form>

    </React.Fragment>
  );
};

export default LoginForm;
