import React from 'react';
import clsx from 'clsx';
import CssBaseline from '@material-ui/core/CssBaseline';
import Container from '@material-ui/core/Container';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import Toolbar from '@material-ui/core/Toolbar';
import Button from '@material-ui/core/Button';
import Divider from '@material-ui/core/Divider';
import Hidden from '@material-ui/core/Hidden';
import Tooltip from '@material-ui/core/Tooltip';
import TextField from '@material-ui/core/TextField';
import { classicNameResolver } from 'typescript';

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


    return (
        <div className={classes.root}>

            <div className={classes.title}>
                <h2>uploading Text</h2>
            </div>
            
            <TextField
                id="TextTitle"
                label="title"
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
                required
                variant="outlined"
                margin="normal"
                fullWidth
                autoFocus
                multiline
                rows={20}
            />
            <Button variant="outlined">upload</Button>
        </div>
    );
}




export default UpVideo;