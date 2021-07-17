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


const useStyles = makeStyles((theme) => ({
    root: {
        width: '700px',
    },
    title: {
        width: '700px',
        height: '70px',
        paddingTop: '20px',
        paddingLeft: '250px',
    },
}));



const UploadHistory = () => {
    const classes = useStyles();

    const [uploadHistory, setuploadHistory] = React.useState([]);

    const fetchUploadHistory = async () => {
        // const responce = await fetch(`http://...`);
        // const data = await response.json();
        // console.log(data.hits). // for test
        // setuploadHistory(data.hits);
    }


    React.useEffect(() => {
        // fetchUploadHistory();
        // fetch history data
    }, []);

    return (
        <div className={classes.root}>

            <div className={classes.title}>
                <h3>Upload History</h3>
            </div>
            
            {uploadHistory.map(oneRecord => (
                <text>a record</text>
            )) }
            <div>
                <Typography>
                    My first contrubution
                </Typography>
            </div>
            <div>
                <Typography>
                    My second contrubution
                </Typography>
            </div>
        </div>
    );
}




export default UploadHistory;