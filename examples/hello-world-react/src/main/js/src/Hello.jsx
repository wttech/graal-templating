import React from "react";

function Hello(props) {

  const calculated = props.name ? props.name : 'World';

  return (
    <div>
      <div>Hello {calculated}!</div>
    </div>
  )

}

export default Hello;
