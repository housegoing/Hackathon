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


const UploadPage = () => {

    const [upText, setUpText] = React.useState(false);
    const [upAudio, setUpAudio] = React.useState(false);
    const [showHistory, setShowHistory] = React.useState(false);

    const uploadText = () => {
        setUpText(!upText);
    }

    const uploadAudio = () => {
        setUpAudio(!upAudio);
    }

    const cancelText = () => {
        setUpText(!upText);
    }

    const cancelAudio = () => {
        setUpAudio(!upAudio);
    }


    const getUploadHistory = () => {
        setShowHistory(!showHistory);
    }

    const closeUploadHistory = () => {
        setShowHistory(!showHistory);
    }


    return (
        <div>
            {
                showHistory 
                ? <UploadHistory></UploadHistory>
                : <Button onClick={getUploadHistory}>Upload History</Button>
            }
            {
                showHistory 
                ? <Button onClick={closeUploadHistory}>Close</Button>
                : <Typography></Typography>
            }
            {
                upText 
                ? <UpVideo></UpVideo>
                :  <Button onClick={uploadText}>Text</Button>
            }
            {
                upText 
                ? <Button onClick={cancelText}>cancel</Button>
                :  <text></text>
            }
            {
                   
                upAudio
                ? <UpAudio></UpAudio>
                :  <Button onClick={uploadAudio}>Audio</Button>
            }
            {
                upAudio 
                ? <Button onClick={cancelAudio}>cancel</Button>
                :  <text></text>
            }
                
        </div>
    );


}





export default UploadPage;