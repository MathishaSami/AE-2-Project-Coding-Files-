import React, {useState, useEffect} from 'react';
import BootstrapTable from 'react-bootstrap-table-next';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.css';
import paginationFactory from 'react-bootstrap-table2-paginator';
import 'react-bootstrap-table2-paginator/dist/react-bootstrap-table2-paginator.min.css';
import filterFactory, {textFilter} from 'react-bootstrap-table2-filter';
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css';



function DataList(){
    const [userList, setUserList] = useState([]);

    const columns = [
        {dataField:'unique_id', text: 'Unique ID'},
        {dataField:'nic_no', text: 'Nic No', sort: true},
        {dataField:'age', text: 'Age', sort: true, filter: textFilter()},
        {dataField:'vaccine_dose', text: 'Vaccine Dose', sort: true, filter: textFilter()},
        {dataField:'vaccine', text: 'Vaccine', sort: true, filter: textFilter()},
        {dataField:'place_of_vaccination', text: 'Place Of Vaccination', sort: true, filter: textFilter()},
        {dataField:'date_of_vaccination', text: 'Date Of Vaccination', sort: true, filter: textFilter()},
        {dataField:'remarks', text: 'Remarks', sort: true, filter: textFilter()}
    ]

    const pagination = paginationFactory({
        page: 1,
        sizePerPage: 10,
        lastPageText: '>>',
        firstPageText: '<<',
        nextPageText: '>',
        prePageText: '<',
        showTotal: true,
        alwaysShowAllBtns: true,
        onPageChange: function (page, sizePerPage) {
            console.log('page', page);
            console.log('sizePerPage', sizePerPage);
        },
        onSizePerPageChange: function (page, sizePerPage){
            console.log('page', page);
            console.log('sizePerPage', sizePerPage);

        }
    });

    useEffect(() => {
      fetch("https://vaccination-nfc.herokuapp.com/web/nfc")
      .then(response => response.json())
      .then(result => setUserList(result))
      .catch(error => console.log(error));
    }, [])

    return <div>
         <BootstrapTable
          bootstrap4
           keyField='nic_no' 
           columns={columns} 
           data={userList}
           pagination={pagination}
           filter={filterFactory()}
        /> 
         </div>

}
 export default DataList;