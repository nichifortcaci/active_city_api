<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <form id="start" name="start" action="/submitNomenculator" method="get">
                <input type="hidden" id="json" name="json" formaction="/submitAtribut">
                <div class="form-group">
                    <label>Nomenclature</label>
                    <input type="text" class="form-control" id="nome">
                </div>
                <div class="form-group">
                    <label for="">Attribute</label>
                    <input type="text" class="form-control" id="attr">
                </div>
                <div class="form-group">
                    <label for="">Type</label>
                    <select class="form-control" id="type">
                        <option value="String">String</option>
                        <option value="int">int</option>
                        <option value="Date">Date</option>
                        <option value="Reference">Reference</option>
                    </select>
                </div>
                <button type="button" class="btn btn-default" id="add">Add</button>
                <button type="submit" class="btn btn-default" id="asd">Inregistreaza nomenculatura</button>
            </form>
        </div>

        <div class="col-md-9">
            <div class="row" id="final">

            </div>
        </div>

    </div>
</div>
<div class="container hidden">
    <div class="row">
        <div class="col-md-6" id="clones">
            <div class="form">
                <div class="col-md-3">
                    <form action="">
                        <h2>nome</h2>
                    </form>
                </div>
            </div>
            <div class="String">
                <div class="form-group">
                    <label for="">text</label>
                    <input type="text" class="form-control">
                </div>
            </div>

            <div class="Date">
                <div class="form-group">
                    <label for="">text</label>
                    <input type="text" class="form-control">
                </div>
            </div>

            <div class="Reference">
                <div class="form-group">
                    <label for="">text</label>
                    <select name="" id="" class="form-control">
                        <option value="Persoana">Persoana</option>
                        <option value="Apartament">Apartament</option>
                        <option value="Comunale">Comunale</option>
                        <option value="Casa">Casa</option>
                    </select>
                </div>
            </div>

            <div class="int">
                <div class="form-group">
                    <label for="">text</label>
                    <input type="number" class="form-control">
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"
        integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script>

    var s = {
        init: false,
        forms: []
    };
    var json = {};
    $(function () {
        $('#add').click(function () {
            var final = $('#final');
            var attr = $('#attr').val();
            if (s.forms.indexOf($('#nome').val()) == -1) {
                var form = $('#clones .form > div').clone();
                form.find('h2').text($('#nome').val());
                form.attr('action', '/qwe')
                form.find('form').attr('id', $('#nome').val());
                form.appendTo(final);
                s.forms.push($('#nome').val())
                json[$('#nome').val()] = []
            }
            var type = $('#type option:selected').val();
            var field = $('#clones .' + type + ' div').clone();
            if(type == 'Reference') {
                var select = field.find('select');
                //select.empty();
                $.getJSON("http://192.168.16.141:8080/get");

            }
            field.find('label').text(attr);
            field.find('input').attr("placeholder", attr);
            final.find('form#' + $('#nome').val()).append(field);

            json[$('#nome').val()].push({
                attribute: attr,
                type: type
            });

        });
        $('#start').submit(function () {
            alert(JSON.stringify(json))
            $(this).find('#json').val(JSON.stringify(json));
        })
    });

</script>
</body>
</html>