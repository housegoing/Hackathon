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
import UpVideo from './components/UpVideo';
import UpAudio from './components/UpAudio';
import UploadHistory from './components/UploadHistry';


const useStyles = makeStyles((theme) => ({
    upload: {
      display: 'flex',
      flexGrow: 1,
      height: '100vh',
      overflow: 'auto',
      width: '2000px',
      
    },
    subUpload: {
      display: 'flex',
      flexGrow: 1,
      height: '100vh',
      overflow: 'auto',
      
    },
    historyButton: {
      height: '70px',
      width: '200px',
      backgroundColor: 'lightgrey',
    },
    videoButton: {
        height: '70px',
        width: '200px',
        backgroundColor: 'lightgrey',
        marginLeft: '30px',
    },
    audioButton: {
        height: '70px',
        width: '200px',
        backgroundColor: 'lightgrey',
        marginLeft: '30px',
    }
  }));

const UploadPage = () => {
    const classes = useStyles();
    const [upText, setUpText] = React.useState(false);
    const [upAudio, setUpAudio] = React.useState(false);
    const [showHistory, setShowHistory] = React.useState(false);

    const uploadText = () => {
        setUpText(!upText);
        setUpAudio(upAudio ? !upAudio : upAudio);
        setShowHistory(showHistory ? !showHistory : showHistory);
    }

    const uploadAudio = () => {
        setUpAudio(!upAudio);
        setUpText(upText ? !upText : upText);
        setShowHistory(showHistory ? !showHistory : showHistory);
    }

    const cancelText = () => {
        setUpText(!upText);
    }

    const cancelAudio = () => {
        setUpAudio(!upAudio);
    }


    const getUploadHistory = () => {
        setShowHistory(!showHistory);
        setUpAudio(upAudio ? !upAudio : upAudio);
        setUpText(upText ? !upText : upText);
    }

    const closeUploadHistory = () => {
        setShowHistory(!showHistory);
    }


    return (

        <div className={classes.upload}>
            <div className={classes.subUpload}>
            {
                showHistory 
                ? <UploadHistory></UploadHistory>
                : <Button className={classes.historyButton} onClick={getUploadHistory}>Upload History</Button>
            }
            {
                showHistory 
                ? <Button className={classes.historyButton} onClick={closeUploadHistory}>Close</Button>
                : <Typography></Typography>
            }
            </div>
            <div className={classes.subUpload}>
            {
                upText 
                ? <UpVideo></UpVideo>
                :  <Button className={classes.videoButton} onClick={uploadText}>Text</Button>
            }
            {
                upText 
                ? <Button className={classes.videoButton} onClick={cancelText}>cancel</Button>
                :  <text></text>
            }
            {
                   
                upAudio
                ? <UpAudio></UpAudio>
                :  <Button className={classes.audioButton} onClick={uploadAudio}>Audio</Button>
            }
            {
                upAudio 
                ? <Button className={classes.audioButton} onClick={cancelAudio}>cancel</Button>
                :  <text></text>
            }
            </div>
        </div>
    );


}





export default UploadPage;