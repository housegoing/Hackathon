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



const UpVideo = () => {
    return (
        <div>
            <TextField
                id="TextTitle"
                label="title"
                required
                variant="outlined"
                margin="normal"
                fullWidth
                autoFocus
                
            />
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
            <Button>upload</Button>
        </div>
    );
}




export default UpVideo;