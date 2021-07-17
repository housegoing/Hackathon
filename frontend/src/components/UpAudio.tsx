import React from 'react';
import clsx from 'clsx';
import CssBaseline from '@material-ui/core/CssBaseline';
import Container from '@material-ui/core/Container';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';



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

    return (
        <div className={classes.root}>

            <div className={classes.title}>
                 <h2>uploading Audio</h2>
            </div>
              
            

            <TextField
                id="AudioTitle"
                label="title"
                required
                fullWidth
                variant="outlined"
                margin="normal"
            />
            <Button variant="outlined">upload</Button>

        </div>
    );
}




export default UpAudio;