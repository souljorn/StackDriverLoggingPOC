import React, {useState} from 'react';
import logo from './logo.svg';
import './App.css';
import {useFetch} from "./hooks";
import Grid from "@material-ui/core/Grid/Grid";
import Typography from "@material-ui/core/Typography/Typography";
import List from "@material-ui/core/List/List";
import ListItem from "@material-ui/core/ListItem/ListItem";
import {makeStyles} from "@material-ui/core";
import ListItemText from "@material-ui/core/ListItemText/ListItemText";
import Paper from "@material-ui/core/Paper";

const useStyles = makeStyles(theme => ({
    root: {
        flexGrow: 1,
        maxWidth: 752,
    },
    demo: {
        backgroundColor: theme.palette.background.paper,
    },
    title: {
        margin: theme.spacing(4, 0, 2),
    },
    paperStyle:{
        backgroundColor: "#9ba5ce",
        margin: theme.spacing(4, 0, 2),
    }
}));

function listComponent(data, classes) {

return(
    <Grid container spacing={2}>
        <Grid item xs={12} md={6}>
            <div>
                <List >
                    {data.map(item => (
                        <Paper className={classes.paperStyle} key={item.name} >
                        <ListItem key={item.name}>

                            <ListItemText
                                primary={"Ship: " + item.name}
                                secondary={"Crew: " + item.crew}
                            />
                        </ListItem>
                        </Paper>
                        ))}
                </List>
            </div>
        </Grid>
    </Grid>
        )
}

export default function App() {

    const classes = useStyles();
    const STARWARS_API = "http://localhost:9999/ships";
    const [data, loading] = useFetch(STARWARS_API);

    return (
        <div className="App">
            <Typography variant={"h3"}>
              Star Wars Ships
            </Typography>
                <>
                    {
                        loading ? '' : listComponent(data, classes)
                    }
                </>

        </div>
    );
}

