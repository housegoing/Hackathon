import React from 'react';
import clsx from 'clsx';
import CssBaseline from '@material-ui/core/CssBaseline';
import Container from '@material-ui/core/Container';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Divider from '@material-ui/core/Divider';
import Hidden from '@material-ui/core/Hidden';
import Tooltip from '@material-ui/core/Tooltip';






const UpAudio = () => {


    return (
        <div>
            <TextField
                id="AudioTitle"
                label="title"
                required
                variant="outlined"
                margin="normal"
            />
            <Button>upload</Button>
        </div>
    );
}




export default UpAudio;