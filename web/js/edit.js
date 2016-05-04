/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var edit = {
    init: function(){
        
        $('.add-to-list').click(function(){
            var $self  = $(this);
            $self.next('ul').append(
                    $('<li><input type="text" value="" name="'+$self.data('name')+'" /></li>')
                    );
            return false;
        });
        
        $('.add-to-org').on('click', 'a', function(){
            var $self  = $(this),
                $parent = $self.closest('.add-to-org'),
                count = ($('.add-to-org .chi').length + 1);
            if($self.hasClass('org')) {
            $self.next('ul').append(
                    $('<li data-num="'+count+'">\n\
    Название: <input type="text" value="" name="'+$parent.data('name')+'_'+count+'_name" />\n\
    url: <input type="text" value="" name="'+$parent.data('name')+'_'+count+'_url" />\n\
<input type="hidden" value="'+count+'" name="'+$parent.data('name')+'_num" /><br/>\n\
\n\<a class="chi" href="#">Добавить организацию</a><ul></ul></li>')
                        );
            } else {
                    var count = $self.closest('li').data('num');
                    $self.next('ul').append($('<li>\n\
    Название: <input type="text" value="" name="'+$parent.data('name')+'_'+count+'_title"/><br/>\n\
 Дата начала: <input type="text" value="" name="'+$parent.data('name')+'_'+count+'_date_start"/><br/>\n\
 Дата конца: <input type="text" value="" name="'+$parent.data('name')+'_'+count+'_date_end"/><br/>\n\
Описание: <textarea  name="'+$parent.data('name')+'_'+count+'_description" cols="50" rows="5"></textarea></li>'));
            }
            return false;
        });
    }
};

$(edit.init);