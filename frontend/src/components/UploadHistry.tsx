import React from 'react';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import axios, {AxiosResponse} from 'axios';


const useStyles = makeStyles((theme) => ({
    root: {
        width: '700px',
        marginRight: '20px',
    },
    title: {
        width: '700px',
        height: '70px',
        paddingTop: '20px',
        paddingLeft: '250px',
    },
    record: {
        width: '200px',
        maxHeight: "200px",
        margin: '10px',
    },
}));



const UploadHistory = () => {
    const classes = useStyles();
    const URL = "http://localhost:8080/getUploadHistory";

    const [uploadHistory, setuploadHistory] = React.useState<HistoryDetail[]>([]);

    

    interface HistoryDetail {
        "title" : string;
        "context" : string;
    };

    React.useEffect(() =>  {
        axios.get<HistoryDetail[]>(URL).then((response : AxiosResponse) => {
            setuploadHistory(response.data);
            console.log("response:", response.data);
        })
    }, []);

    // return include 2 showing example

    return (
        <div className={classes.root}>

            <div className={classes.title}>
                <h3>Upload History</h3>
            </div>
            <hr/>
            {uploadHistory.map(oneRecord => (
                <div className={classes.record}>
                <div>
                    <Typography>
                        Title: {oneRecord.title}
                    </Typography>

                </div>
                <div>
                    <Typography> Context: example_context{oneRecord.context}
                    </Typography>
                </div>
                <hr/>
            </div>
            )) }
            <div  className={classes.record}>
                <div>
                    <Typography>
                        Title: example_title{}
                    </Typography>

                </div>
                
                <div>
                    <Typography> 
                        Context: example_context{}
                    </Typography>
                </div>
                    
            </div>
            <hr/>
            <div className={classes.record}>
                <div>
                    <Typography>
                        Title: example_title{}
                    </Typography>

                </div>
                <div>
                    <Typography> 
                        Context: example_context{}
                    </Typography>
                </div>
            </div>
            <hr/>
        </div>
    );
}




export default UploadHistory;