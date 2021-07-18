import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import axios from 'axios';

// Video means text

const useStyles = makeStyles((theme) => ({
    root: {
        width: '900px',
    },
    title: {
        width: '700px',
        height: '70px',
        paddingTop: '20px',
        paddingLeft: '350px',

    },
}));

const UpVideo = () => {
    const classes = useStyles();
    const titleRef = React.createRef<HTMLInputElement>();
    const linkRef = React.createRef<HTMLInputElement>();
    const URL = "http://localhost:8080/addArticle";

    const submitText = () => {
        try {
            console.log("signup...");
            axios.post(URL, {
                  "link": titleRef.current?.value,
                  "name": linkRef.current?.value,
              });
            alert("thank you for your uploading");
          } catch (error) {
            console.log("submit text error");
            alert("opps, something is going wrong");
          }
    }

    return (
        <div className={classes.root}>

            <div className={classes.title}>
                <h2>uploading Text</h2>
            </div>
            
            <TextField
                id="TextTitle"
                label="title"
                inputRef={titleRef}
                required
                variant="outlined"
                margin="normal"
                fullWidth
                autoFocus
                
            />
            <br/>
            <TextField
                id="textContext"
                label="context"
                inputRef={linkRef}
                required
                variant="outlined"
                margin="normal"
                fullWidth
                autoFocus
                multiline
                rows={20}
            />
            <Button variant="outlined" onClick={submitText}>upload</Button>
        </div>
    );
}




export default UpVideo;