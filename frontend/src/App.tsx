import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

import LoginForm from './components/LoginForm'
import SignupForm from './components/SignupForm';
import UploadPage from './uploadpage';
import publisherDetail from './service/userService';
import userService from './service/userService';
import axios, {AxiosResponse} from 'axios';

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';


const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    flexGrow: 1,
    height: '100vh',
    overflow: 'auto',
    width: '1800px',
    flexDirection: "column",
  },
  signupButton: {
    height: '70px',
    width: '200px',
    
  },
  buttonDiv: {
    width: '1500px',
    paddingLeft: '830px',
  }
}));


function AppRouter() {
  const classes = useStyles();
  const [showSignForm, setShowSignForm] = React.useState(false);
  const [logedin, setLogedin] = React.useState(false);
  const [publishers, setPublishers] = React.useState<publisherDetail[]>([]);
  const Publisher_URL = "http://localhost:8080/addPublisher";

  const showSignup = () => {
    setShowSignForm(!showSignForm);
  }

  interface publisherDetail {
    email: string,
    FirstName: string,
    lastName: string,
  
  };
  


  React.useEffect(() =>  {
    axios.get<publisherDetail[]>(Publisher_URL).then((response : AxiosResponse) => {
      setPublishers(response.data);
      console.log("response:", response.data);
    })
  }, []);

  
  return (
    <Router>
      <Switch>
        <div className={classes.root}>
          
        <Route path="/">
          <div className={classes.buttonDiv}>
            <Button className={classes.signupButton} onClick={showSignup} > {showSignForm ? "go to login" : "go to signup"} </Button>
          </div>
          
          {
            logedin ? <Typography>dear volunteer, thank you for coming ^ _ ^ </Typography>
            :
            <div>
            {
              showSignForm ? <SignupForm /> : <LoginForm />
            } 
            </div>
          }
          
            
        </Route>
        <hr/>

        <div className={classes.root}>
          <Route path="/uploadpage" component={UploadPage} />
        </div>

        </div>
      </Switch>
   
    </Router>
      
  );
}

export default AppRouter;
