import React from 'react';
import clsx from 'clsx';
import CssBaseline from '@material-ui/core/CssBaseline';
import Container from '@material-ui/core/Container';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import axios, {AxiosResponse} from 'axios';


const useStyles = makeStyles((theme) => ({
    root: {
        width: '400px',
        marginLeft: '30px',
    },
    title: {
        width: '700px',
        height: '70px',
        paddingTop: '20px',
        paddingLeft: '100px',
    },
}));



const UpAudio = () => {
    const classes = useStyles();
    const titleRef = React.createRef<HTMLInputElement>();
    const linkRef = React.createRef<HTMLInputElement>();
    const URL = "http://localhost:8080/addAudio";

    const submitAudio = () => {
        try {
            console.log("signup...");
            axios.post(URL, {
                  "link": titleRef.current?.value,
                  "name": linkRef.current?.value,
              });
            alert("thank you for your uploading");
          } catch (error) {
            console.log("submit audio error");
            alert("opps, something is going wrong");
          }

    }



    return (
        <div className={classes.root}>

            <div className={classes.title}>
                 <h2>uploading Audio</h2>
            </div>
              
            

            <TextField
                id="AudioTitle"
                label="title"
                inputRef={titleRef}
                required
                fullWidth
                variant="outlined"
                margin="normal"
            />
            <TextField
                id="AudioLink"
                label="link"
                inputRef={linkRef}
                required
                fullWidth
                variant="outlined"
                margin="normal"
                multiline
                rows={5}
            />
            <Button variant="outlined" onClick={submitAudio}>upload</Button>

        </div>
    );
}




export default UpAudio;