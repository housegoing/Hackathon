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






const UploadHistory = () => {

    const [uploadHistory, setuploadHistory] = React.useState();

    React.useEffect(() => {
        // fetch history data
    }, []);

    return (
        <div>
            <text>Upload History here</text>
        </div>
    );
}




export default UploadHistory;